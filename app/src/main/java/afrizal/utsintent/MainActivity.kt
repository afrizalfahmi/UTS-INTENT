package afrizal.utsintent

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlinpermissions.KotlinPermissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        KotlinPermissions.with(this) // where this is an FragmentActivity instance
            .permissions(Manifest.permission.CAMERA)
            .onAccepted { permissions ->
                //List of accepted permissions
            }
            .onDenied { permissions ->
                //List of denied permissions
            }
            .onForeverDenied { permissions ->
                //List of forever denied permissions
            }
            .ask()
        btnPindahActivityExplisit.setOnClickListener {
            startActivity(Intent(this, ExplisitIntentActivity::class.java))
        }
        btnPindahActivityImplisit.setOnClickListener {
            startActivity(Intent (this,ImplisitIntentActivity::class.java ))
        }
        btnPindahActivityIntentBundle.setOnClickListener {
            val intent : Intent = Intent (this, IntentBundleActivity::class.java)
            intent.putExtra("Nama Panggilan", "Afrizal Manis")
            intent.putExtra("TTL", "Jepara, 02 Juli 1998")
            intent.putExtra("Alamat Rumah", "Ds.Cepogo Rt 01/06 Kec Kembang Jepara")
            intent.putExtra("Hobby", "Makan, Nonton, Game")
            intent.putExtra("Agama", "Islam")
            intent.putExtra("Email", "aghrizal@gmail.com")
            intent.putExtra("FOTO", "azal.jpg")

            startActivity(intent)

        }
    }

}
