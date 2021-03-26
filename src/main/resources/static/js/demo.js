$(document).ready(function () {
    /*$("#btnPrint").click(function () {
        console.log("into...");
        //tableID为要打印表格的id，fileName为打印后表格的文件名
        tableToExcel("tbPrint","demo");
        console.log("success!");
    })*/
})

//将html文本转换成excel
function base64(content) {
    return window.btoa(unescape(encodeURIComponent(content)));
}

function tableToExcel(tableID, fileName) {
    //获取table的html文本
    var excelContent = $("#" + tableID).html();
    //alert(excelContent);
    var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
    excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
    //设置表格样式
    excelFile += "<body><table width='10%'  border='1'>";
    excelFile += excelContent;
    excelFile += "</table></body>";
    excelFile += "</html>";
    //提供下载链接
    var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
    var a = document.createElement("a");
    //需要下载的文件名
    a.download = fileName + ".xls";
    a.href = link;
    a.click();
}