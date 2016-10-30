/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediasharingdsl

// Load file MediaSharing.groovy
def script = new GroovyScriptEngine( '.' ).with {
  loadScriptByName( 'src/mediasharingdsl/MediaSharing.groovy' )
} 
this.metaClass.mixin script


// Domain Specific Language
download 1 // Download media by ID = 1
sign up username "vany" email "vanydeasy@gmail.com" password "12345" first_name "vanya" last_name "deasy"
like 1 by "vany"
sign up username "venny" email "vennylaras@gmail.com" password "12345" first_name "venny" last_name "larasati"
dislike 1 by "venny"
sign up username "pipin" email "pipin@gmail.com" password "12345" first_name "pipin" last_name "kurniawati"
comment 1 by "pipin" parent "My First Video!" content "haha"
upload 1 file "nyanyi.mp4" title "orang gila nyanyi" type "mp4" description "ada orang gila lagi nanyi, keren" permission "public" path "/watch?v=G32anf8s" by "venny"
