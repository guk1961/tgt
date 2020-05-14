<#import "parts/common.ftl" as c>

<@c.page>
Список пользователей

<table class="table table-hover">
    <thead>
    <tr>
        <th>Логин</th>
        <th>Роли</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
        	<td><a class="col align-self-center" href="/user-messages/${user.id}">
        		<i class="far fa-address-card"></i>
        		${user.username}
        		</a>
        	</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">
            	<i class="fas fa-user-edit"></i>
            </a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>
