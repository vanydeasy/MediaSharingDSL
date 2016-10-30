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
create "Media", {
    name "Vany"
    link "Huba"
    createdAt 2015-10-11
}
create "User"

printMedia()