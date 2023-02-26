package com.example.mymovieapp.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymovieapp.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splash_image.animate().setDuration(3000).alpha(1f).withEndAction {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            finish()
        }
    }
}


// Bu kod,
// bir splash screen veya açılış ekranında bir görüntüyü animasyonlu olarak gösterir.
// splash_image isimli bir ImageView elemanının alpha değeri, 3 saniye boyunca yavaşça 1'e yani tamamen opak hale getirilir.
// Bu işlem, animate() metodu kullanılarak gerçekleştirilir ve setDuration() metodu ile süre belirtilir.
//
// withEndAction: alpha animasyonunun tamamlandığında çalışacak bir işlev belirtir.
// Burada, bir Intent nesnesi oluşturulur ve MainActivity'ye yönlendirmek için kullanılır.
// startActivity() metodu: MainActivity'nin açılması için kullanılır.
//
// overridePendingTransition() metodu: ekran geçiş animasyonlarını ayarlamak için kullanılır.
// android.R.anim.fade_in ve android.R.anim.fade_out animasyon kaynaklarının kullanılması,
// MainActivity'nin görünürlüğüne geçişin yavaşça soluklaşarak (fade-out) ve açılırken (fade-in) yumuşak bir şekilde gerçekleştirilmesini sağlar.
//
// finish() metodu:
// SplashActivity'nin sonlandırılmasını sağlar.
// Bu, kullanıcı SplashActivity'de geri düğmesine basarsa uygulamanın tekrar SplashActivity'e dönmemesi için kullanışlıdır.