package cn.com.jldata.core.jpa;

import cn.com.jldata.core.query.PropertyFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
public class BaseRepositoryImpl <T, ID extends Serializable>extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>  {

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     * @param em must not be {@literal null}.
     */
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass,em);
    }

    @Override
    public <S extends T> Page<S> findAll(List<PropertyFilter> propertyFilters, Pageable pageable) {
        return this.findAll(JpaQueryUtil.buildSpecification(propertyFilters),pageable);
    }

}
