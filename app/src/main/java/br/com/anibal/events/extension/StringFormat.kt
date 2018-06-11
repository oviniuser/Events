package br.com.anibal.events.extension

fun String.getBrDate(): String {
    val separatedDate = this.split("-")
    val month = separatedDate[1].toInt() -1
    val months = arrayOf("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro")
    val brDate = separatedDate[2] + " de " + months[month] + " de " + separatedDate[0]
    return brDate
}