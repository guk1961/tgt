<#import "parts/common.ftl" as c>

<@c.page>
<h3><i class="far fa-address-card"></i> ${userChannel.username}</h3>
<#if !isCurrentUser>
    <#if isSubscriber>
        <a class="btn btn-outline-secondary btn-sm" href="/user/unsubscribe/${userChannel.id}">Отписаться</a>
    <#else>
        <a class="btn btn-outline-secondary btn-sm" href="/user/subscribe/${userChannel.id}">Подписаться</a>
    </#if>
</#if>


<div class="container my-3">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <div class="card-title">
                      <a href="/user/subscriptions/${userChannel.id}/list" class="btn btn-outline-secondary btn-sm">Подписки ${subscriptionsCount}</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <div class="card-title">
                        <a href="/user/subscribers/${userChannel.id}/list" class="btn btn-outline-secondary btn-sm">Подписчики ${subscribersCount}</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#if isCurrentUser>
    <#include "parts/messageEdit.ftl" />
</#if>

<#include "parts/messageList.ftl" />
</@c.page>
