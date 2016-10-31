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

/**
 * 1 sign up username [username] email [email] password [password] first_name [first_name] last_name [last_name]
 * 2 upload [category_id] file [file_name] title [title] type [type] description [description] permission [permission] path [url_path] by [username]
 * 3 download [media_id]
 * 4 like [media_id] by [username]
 * 5 dislike [media_id] by [username]
 * 6 comment [media_id] by [username] parent [comment_id] content [content]
 * 7 signin [username] password [password]
 */

sign up username "johndoe" email "johndoeinlove@gmail.com" password "12345" first_name "John" last_name "Doe" // Sign up
upload 1 file "nyanyi.mp4" title "orang gila nyanyi" type "mp4" description "ada orang lagi nanyi, keren" permission "public" path "/watch?v=G32anf8s" by "johndoe" // Upload media
download 1 // Download media by ID = 1
like 1 by "johndoe" // Like media by ID = 1
dislike 1 by "johndoe" // Dislike media by ID = 1
comment 1 by "johndoe" parent 0 content "hooooo" // Comment media by ID = 1
signin "johndoe" password "12345"