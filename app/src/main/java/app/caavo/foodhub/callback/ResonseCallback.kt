package app.caavo.foodhub.callback

interface ResponseCallback {
    fun onSuccess(any: Any)
    fun onFailure(message: String)
}