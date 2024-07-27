<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2>Hello, BuySell</h2>
<h4>Подробная информация</h4>
<#--<img src="/images/${product.images.get(0)}"  height="60px"> <br> <br>-->
<#--<img src="/images/${product.images.get(1)?if_exists}" height="60px"> <br> <br>-->
<#--<img src="/images/${product.images.get(2)?if_exists}" height="60px"> <br> <br>-->
<#--<#list images  as image>-->
<#--    <img src="/images/${image.id}" height="60px" alt="">-->
<#--</#list>-->
<B>Артикул: </B> ${product.id} <br>
<B>Название товара: </B> ${product.title} <br>
<B>Описание товара: </B> ${product.description} <br>
<B>Цена: </B> ${product.price} <br>
<B>Город: </B> ${product.city} <br>
<B>Автор: </B> ${product.author} <br>
<hr>
<h3>Создать товар</h3>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар">
</form>
</body>
</html>