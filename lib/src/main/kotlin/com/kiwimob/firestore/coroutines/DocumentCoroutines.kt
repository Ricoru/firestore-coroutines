package com.kiwimob.firestore.coroutine

import com.google.firebase.firestore.*
import kotlinx.coroutines.experimental.NonCancellable
import kotlinx.coroutines.experimental.suspendCancellableCoroutine

suspend fun <T : Any> DocumentReference.await(clazz: Class<T>): T {
    return await { documentSnapshot -> documentSnapshot.toObject(clazz) }
}

suspend fun <T : Any> DocumentReference.await(parser: (documentSnapshot: DocumentSnapshot) -> T): T {
    return suspendCancellableCoroutine { continuation ->
        get().addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(parser.invoke(it.result))
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}

suspend fun DocumentReference.deleteAwait() {
    return suspendCancellableCoroutine { continuation ->
        delete().addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}

suspend fun DocumentReference.updateAwait(var1: Map<String, Any>) {
    return suspendCancellableCoroutine { continuation ->
        update(var1).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}

suspend fun DocumentReference.updateAwait(var1: FieldPath, var2: Any, var3: List<Any>) {
    return suspendCancellableCoroutine { continuation ->
        update(var1, var2, var3).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}

suspend fun DocumentReference.updateAwait(var1: String, var2 : Any, var3: List<Any>) {
    return suspendCancellableCoroutine { continuation ->
        update(var1, var2, var3).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}

suspend fun DocumentReference.setAwait(var1: Any) {
    return suspendCancellableCoroutine { continuation ->
        set(var1).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}


suspend fun DocumentReference.setAwait(var1: Map<String, Any>) {
    return suspendCancellableCoroutine { continuation ->
        set(var1).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}

suspend fun DocumentReference.setAwait(var1: Any, var2 : SetOptions) {
    return suspendCancellableCoroutine { continuation ->
        set(var1, var2).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}

suspend fun DocumentReference.setAwait(var1: Map<String, Any>, var2: SetOptions) {
    return suspendCancellableCoroutine { continuation ->
        set(var1, var2).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(it.exception!!)
            }
        }

        continuation.invokeOnCompletion {
            if (continuation.isCancelled)
                try {
                    NonCancellable.cancel()
                } catch (ex: Throwable) {
                    //Ignore cancel exception
                }
        }
    }
}