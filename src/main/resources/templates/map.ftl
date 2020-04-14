<#import "parts/common.ftl" as c>

<@c.page>
List of citys

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Lat</th>
        <th>Lng</th>
    </tr>
    </thead>
    <tbody>
    <#list citys as city>
        <tr>
            <td>${city.name}</td>
            <td>${city.lat}</td>
            <td>${city.lng}</td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>
