# 📱 Ödev 4 – Navigation Component ile Sayfa Geçişleri (Kotlin - Android Studio)

## 🎯 Proje Amacı
Bu proje, Android Studio üzerinde **Kotlin dili** kullanılarak, **Navigation Component** yardımıyla **fragmentler arası geçişleri** uygulamalı şekilde göstermektedir. Verilen diyagramdaki sayfa akış yapısı birebir uygulanmıştır.

---

## 🧱 Kullanılan Teknolojiler
- Kotlin
- Android Jetpack Navigation Component
- View Binding
- Fragment yapısı
- OnBackPressedCallback (Geri tuşu yönetimi)
- Log kullanımı (Yaşam döngüsü için)

---

## 🧭 Sayfa Geçiş Yapısı

Proje, aşağıdaki fragment yapısına sahiptir:

1. **AnasayfaFragment**
   - `GiT > A` butonu → SayfaA'ya (`AFragment`)
   - `GiT > X` butonu → SayfaX'e (`XFragment`)

2. **AFragment**
   - `GiT > B` butonu → SayfaB (`BFragment`)

3. **BFragment**
   - `GiT > Y` butonu → SayfaY (`YFragment`)

4. **XFragment**
   - `GiT > Y` butonu → SayfaY (`YFragment`)

5. **YFragment**
   - Geri tuşuna basıldığında doğrudan **AnasayfaFragment**'a geri döner.

---

## 🔁 Geri Tuşu Özelliği
**YFragment** içerisinde `OnBackPressedCallback` kullanılarak sistem geri tuşuna basıldığında kullanıcı doğrudan Anasayfa'ya yönlendirilir:
```kotlin
val callback = object : OnBackPressedCallback(true) {
    override fun handleOnBackPressed() {
        findNavController().navigate(R.id.anasayfaFragment)
    }
}
requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
```

---

## 📝 Yaşam Döngüsü Logları
`AnasayfaFragment` içinde yaşam döngüsünü izlemek için `Log` mesajları eklenmiştir:
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.e("yaşam döngüsü", "onCreate")
}

override fun onResume() {
    super.onResume()
    Log.e("yaşam döngüsü", "onResume")
}
```

---

## 📂 Navigation Setup
- `nav_graph.xml` dosyası içinde tüm fragment geçişleri tanımlandı.
- Her buton, `Navigation.findNavController(view).navigate(R.id.gecisId)` ile ilgili geçişe yönlendirildi.
- View Binding ile butonlara erişildi ve tıklama işlemleri tanımlandı.

---

## 🧪 Test Senaryoları
- Anasayfa → A → B → Y → (geri tuşu) → Anasayfa ✅  
- Anasayfa → X → Y → (geri tuşu) → Anasayfa ✅  

---

## 📌 Not
- ViewBinding projenin her fragmentinde aktif olarak kullanılmıştır.
- Navigation Component ile yönlendirme sade ve okunabilir yapıdadır.
