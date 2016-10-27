$(function(){
    var menuMenu = $('#menu #menuMenu')[0];
    var menuOrders = $('#menu #menuOrders')[0];
    var menuSetting = $('#menu #menuSetting')[0];
    var shopOrder = $('#menu #shopOrder')[0];
    var shopAdv = $('#menu #shopAdv')[0];
    var shopSetting = $('#menu #shopSetting')[0];
    var dishSetting = $('#menu #dishSetting')[0];


    menuMenu && menuMenu.onclick = function(){
        window.location.href = "shop.html";
    }
    menuOrders && menuOrders.onclick = function(){
        window.location.href = "history.html";
    }
    menuSetting && menuSetting.onclick = function(){
        window.location.href = "account.html";
    }
    shopOrder && shopOrder.onclick = function(){
        window.location.href = "order.html";
    }
    shopAdv && shopAdv.onclick = function(){
        window.location.href = "adv.html";
    }
    shopSetting && shopSetting.onclick = function(){
        window.location.href = "edit.html";
    }
    dishSetting && dishSetting.onclick = function(){
        window.location.href = "dishEdit.html";
    }
});