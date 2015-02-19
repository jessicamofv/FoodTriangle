/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var canvasWidth;
var canvasHeight;
var canvas;
var canvas2D;
var radius;

function showProgress(/*fruitsAmount, fruitsReq, vegetablesAmount, vegetablesReq,
 * grainsAmount, grainsReq, proteinAmount, proteinReq, dairyAmount, dairyReq,
 * oilsAmount, oilsReq*/)
{
    canvasWidth = 800;
    canvasHeight = 600;
    canvas = document.getElementById("progressCanvas");
    canvas2D = canvas.getContext("2d");
    radius = 80;
    
    var fruitsAmount = 0.5;
    var fruitsReq = 2;
    var vegetablesAmount = 1;
    var vegetablesReq = 2.5;
    var grainsAmount = 2;
    var grainsReq = 6;
    var proteinAmount = 1.5;
    var proteinReq = 5.5;
    var dairyAmount = 0.75;
    var dairyReq = 3;
    var oilsAmount = 2;
    var oilsReq = 6;
    
    drawAndFillCircle(fruitsAmount, fruitsReq, 160, 490, "crimson", "Fruits");
    drawAndFillCircle(vegetablesAmount, vegetablesReq, 400, 490, "green", "Vegetables");
    drawAndFillCircle(grainsAmount, grainsReq, 640, 490, "GoldenRod", "Grains");
    drawAndFillCircle(proteinAmount, proteinReq, 280, 300, "sienna", "Protein");
    drawAndFillCircle(dairyAmount, dairyReq, 520, 300, "wheat", "Dairy");
    drawAndFillCircle(oilsAmount, oilsReq, 400, 110, "olive", "Oils");
}

function drawAndFillCircle(amount, requirement, x, y, color, label)
{
    var percentage = amount / requirement;
    var percentageAngle = percentage * 2 * Math.PI;
    canvas2D.beginPath();
    canvas2D.arc(x, y, radius, 0, percentageAngle, false);
    canvas2D.lineTo(x, y);
    canvas2D.closePath();
    canvas2D.fillStyle = color;
    canvas2D.fill();
    canvas2D.lineWidth = 4;
    canvas2D.strokeStyle = 'grey';
    canvas2D.stroke();
    
    canvas2D.beginPath();
    canvas2D.arc(x, y, radius, 0, 2 * Math.PI, false);
    canvas2D.lineWidth = 4;
    canvas2D.strokeStyle = 'grey';
    canvas2D.stroke();
    
    canvas2D.font = 'bold 20px Georgia';
    canvas2D.fillStyle = 'black';
    canvas2D.textAlign = 'center';
    canvas2D.fillText(label, x, y);
}

