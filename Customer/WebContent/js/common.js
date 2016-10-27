$(function(){
    var menuMenu = $('#menu #menuMenu')[0];
    var menuOrders = $('#menu #menuOrders')[0];
    var menuSetting = $('#menu #menuSetting')[0];

    menuMenu.onclick = function(){
        window.location.href = "shop.html";
    }
    menuOrders.onclick = function(){
        window.location.href = "history.html";
    }
    menuSetting.onclick = function(){
        window.location.href = "account.html";
    }
});