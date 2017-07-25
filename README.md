XML Çözümleme farklı platformların birbiri ile etkileşim sağladığının güzel örneğidir.XML çözümleme Event Based ve Object Based olmak üzere ikiye ayrılır, bu yöntemelerin en yaygınları 
SAX(Event) ve DOM(Object)'dur.
-DOM Parserında Document nesnesi üzerinden işlem yapar.Tüm nesneleri belleğe yüklerler.
-SAX Parserlar ise belleğe belli eventleri yükledikleri için daha verimli çalışırlar ve bellek israfını azaltırlar.Bu nedenle  server-side 
tarafında kullanılan uygulamalarda daha çok kullanılır.
