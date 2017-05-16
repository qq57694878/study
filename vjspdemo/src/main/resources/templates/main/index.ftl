<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <#macro m_list data>
    <ul>
        <#list data as m>
            <li>
                <#list m?keys as key>
                ${key}:${m[key]}
                </#list>
            </li>
        </#list>
    </ul>
        <#nested>
    </#macro>

<@m_list data=list>
ss
</@m_list>
<#assign x=10 />
    <#if x == 1>
    x is 1
    <#elseif x == 2>
    x is 2
    <#elseif x == 3>
    x is 3
    <#else>
    x is other
    </#if>

</body>
</html>