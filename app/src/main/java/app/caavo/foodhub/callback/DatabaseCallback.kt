package app.caavo.foodhub.callback

interface DatabaseCallback {
    fun onSuccess(model: Any)
    fun onError(e: Throwable)
}