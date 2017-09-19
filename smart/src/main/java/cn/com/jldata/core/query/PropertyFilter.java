package cn.com.jldata.core.query;

import cn.com.jldata.core.util.ConvertUtils;
import cn.com.jldata.core.util.ServletUtils;
import cn.com.jldata.core.util.StringUtils;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * property filter.
 * 
 * @author Lingo
 */
public class PropertyFilter {

    /** match type. */
    private MatchType matchType;

    /** match value. */
    private Object matchValue;

    /** property class. */
    private Class<?> propertyClass;

    /** property names. */
    private String propertyName;

    /**
     * default constructor.
     */
    public PropertyFilter() {
    }

    /**
     * constructor.
     * 
     * @param filterName
     *            String
     * @param value
     *            String
     */
    public PropertyFilter(final String filterName, final String value) {
        String firstPart = StringUtils.substringBefore(filterName, "_");
        String matchTypeCode = StringUtils.substring(firstPart, 0,
                firstPart.length() - 1);
        String propertyTypeCode = StringUtils.substring(firstPart,
                firstPart.length() - 1, firstPart.length());

        try {
            matchType = Enum.valueOf(MatchType.class, matchTypeCode);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("filter名称" + filterName
                    + "没有按规则编写,无法得到属性比较类型.", e);
        }

        try {
            propertyClass = Enum.valueOf(PropertyType.class, propertyTypeCode)
                    .getValue();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("filter名称" + filterName
                    + "没有按规则编写,无法得到属性值类型.", e);
        }

        propertyName = StringUtils.substringAfter(filterName, "_");
        Assert.isTrue(StringUtils.isNotBlank(propertyName), "filter名称"
                + filterName + "没有按规则编写,无法得到属性名称.");

        if (matchType == MatchType.IN) {
            this.matchValue = convertStringToCollection(value, propertyClass);
        } else {
            this.matchValue = ConvertUtils.convertStringToObject(value,
                    propertyClass);
        }
    }

    private <T> Collection<T> convertStringToCollection(String text,
            Class<T> propertyClass) {
        List<T> list = new ArrayList<T>();

        for (String value : text.split(",")) {
            list.add((T) ConvertUtils.convertStringToObject(value,
                    propertyClass));
        }

        return list;
    }

    /**
     * build from request.
     * 
     * @param request
     *            HttpServletRequest
     * @return list
     */
    public static List<PropertyFilter> buildFromHttpRequest(
            final HttpServletRequest request) {
        return buildFromHttpRequest(request, "filter_");
    }

    /**
     * build from request.
     * 
     * @param request
     *            HttpServletRequest
     * @param filterPrefix
     *            String
     * @return list
     */
    public static List<PropertyFilter> buildFromHttpRequest(
            final HttpServletRequest request, final String filterPrefix) {
        // 从request中获取含属性前缀名的参数,构造去除前缀名后的参数Map.
        Map<String, Object> filterParamMap = ServletUtils
                .getParametersStartingWith(request, filterPrefix);

        return build(filterParamMap);
    }

    public static List<PropertyFilter> buildFromMap(
            Map<String, Object> parameterMap) {
        return buildFromMap(parameterMap, "filter_");
    }

    public static List<PropertyFilter> buildFromMap(
            Map<String, Object> parameterMap, String filterPrefix) {
        Map<String, Object> filterParamMap = new TreeMap<String, Object>();

        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.startsWith(filterPrefix)) {
                filterParamMap.put(key.substring(filterPrefix.length()), value);
            }
        }

        return build(filterParamMap);
    }

    public static List<PropertyFilter> build(Map<String, Object> filterParamMap) {
        List<PropertyFilter> filterList = new ArrayList<PropertyFilter>();

        // 分析参数Map,构造PropertyFilter列表
        for (Map.Entry<String, Object> entry : filterParamMap.entrySet()) {
            String filterName = entry.getKey();
            Object filterValue = entry.getValue();
            String value = null;

            if (filterValue instanceof String[]) {
                value = ((String[]) filterValue)[0];
            } else {
                value = (String) filterValue;
            }

            // 如果value值为空,则忽略此filter.
            if (StringUtils.isNotBlank(value)) {
                PropertyFilter filter = new PropertyFilter(filterName, value);
                filterList.add(filter);
            }
        }

        return filterList;
    }

    /** @return property class. */
    public Class<?> getPropertyClass() {
        return propertyClass;
    }

    /** @return MatchType. */
    public MatchType getMatchType() {
        return matchType;
    }

    /** @return MatchValue. */
    public Object getMatchValue() {
        return matchValue;
    }

    /** @return property name. */
    public String getPropertyName() {
        return propertyName;
    }

}
