package cn.com.jldata.core.jpa;

import cn.com.jldata.core.query.MatchType;
import cn.com.jldata.core.query.PropertyFilter;
import cn.com.jldata.core.util.BeanUtils;
import com.sun.istack.internal.Nullable;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.*;
import org.hibernate.criterion.Expression;
import org.hibernate.internal.CriteriaImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.core.support.ExampleMatcherAccessor;
import org.springframework.data.util.DirectFieldAccessFallbackBeanWrapper;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.SingularAttribute;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljl
 */
public class JpaQueryUtil {
    /** logger. */
    private static Logger logger = LoggerFactory.getLogger(JpaQueryUtil.class);

    private static final Set<Attribute.PersistentAttributeType> ASSOCIATION_TYPES;

    static {
        ASSOCIATION_TYPES = new HashSet<>(Arrays.asList(Attribute.PersistentAttributeType.MANY_TO_MANY,
                Attribute.PersistentAttributeType.MANY_TO_ONE, Attribute.PersistentAttributeType.ONE_TO_MANY, Attribute.PersistentAttributeType.ONE_TO_ONE));
    }
    private static Map<String,PropertyFilter> converMap(List<PropertyFilter>propertyFilters){
        Map<String,PropertyFilter> result = new HashMap<String,PropertyFilter>();
        for(PropertyFilter propertyFilter:propertyFilters){
            result.put(propertyFilter.getPropertyName(),propertyFilter);
        }
        return result;
    }

    public static <T> Predicate getPredicate(Root<T> root, CriteriaBuilder cb, List<PropertyFilter> propertyFilters) {

        Assert.notNull(root, "Root must not be null!");
        Assert.notNull(cb, "CriteriaBuilder must not be null!");
        Assert.notNull(propertyFilters, "PropertyFilters must not be null!");
        Map<String,PropertyFilter> propertyFilterMap =  converMap(propertyFilters);


        List<Predicate> predicates = getPredicates("", cb, root, root.getModel(), propertyFilterMap);

        if (predicates.isEmpty()) {
            return cb.isTrue(cb.literal(true));
        }

        if (predicates.size() == 1) {
            return predicates.iterator().next();
        }

        Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

        return cb.and(array);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    static List<Predicate> getPredicates(String path, CriteriaBuilder cb, Path<?> from, ManagedType<?> type, Map<String,PropertyFilter> propertyFilters) {

        List<Predicate> predicates = new ArrayList<>();

        for (SingularAttribute attribute : type.getSingularAttributes()) {

            String currentPath = !StringUtils.hasText(path) ? attribute.getName() : path + "." + attribute.getName();
            PropertyFilter propertyFilter = propertyFilters.get(currentPath);
            if (propertyFilter==null) {
                continue;
            }
            Object attributeValue = propertyFilter.getMatchValue();
            if(attributeValue==null){
                continue;
            }
            //  predicates.add(cb.isNull(from.get(attribute)));
            if (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.EMBEDDED)) {
                predicates.addAll(getPredicates(currentPath, cb, from.get(attribute.getName()),
                        (ManagedType<?>) attribute.getType(), propertyFilters));
                continue;
            }

            if (isAssociation(attribute)) {
                if (!(from instanceof From)) {
                    throw new JpaSystemException(new IllegalArgumentException(String
                            .format("Unexpected path type for %s. Found %s where From.class was expected.", currentPath, from)));
                }
                predicates.addAll(getPredicates(currentPath, cb, ((From<?, ?>) from).join(attribute.getName()),
                        (ManagedType<?>) attribute.getType(), propertyFilters));
                continue;
            }
            Predicate predicate = null;
                MatchType matchType = propertyFilter.getMatchType();
                // 根据MatchType构造predicate
                switch (matchType) {
                    case EQ:
                        predicate = cb.equal(from.get(attribute), attributeValue);
                        break;
                    case NOT:
                        predicate = cb.notEqual(from.get(attribute), attributeValue);
                        break;
                    case CONTAIN:
                        predicate = cb.like(from.get(attribute), "%" + attributeValue + "%");
                        break;
                    case START:
                        predicate = cb.like(from.get(attribute), attributeValue + "%");
                        break;
                    case END:
                        predicate = cb.like(from.get(attribute), "%" + attributeValue);
                        break;
                    case LE:
                        predicate = cb.le(from.get(attribute),(Number)attributeValue);
                        break;
                    case LT:
                        predicate = cb.lt(from.get(attribute),(Number)attributeValue);
                        break;
                    case GE:
                        predicate = cb.ge(from.get(attribute),(Number)attributeValue);
                        break;
                    case GT:
                        predicate = cb.gt(from.get(attribute),(Number)attributeValue);
                        break;
                    case IN:
                        cb.in(from.get(attribute).in((Collection)attributeValue));
                        break;
                    case INL:
                        predicate = cb.isNull(from.get(attribute));
                        break;
                    case NNL:
                        predicate = cb.isNotNull(from.get(attribute));
                        break;
                    default:
                        predicate =cb.equal(from.get(attribute), attributeValue);
                        break;
                }
            predicates.add(predicate);
        }
        return predicates;
    }

    private static boolean isAssociation(Attribute<?, ?> attribute) {
        return ASSOCIATION_TYPES.contains(attribute.getPersistentAttributeType());
    }



}
