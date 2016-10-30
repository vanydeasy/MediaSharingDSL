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