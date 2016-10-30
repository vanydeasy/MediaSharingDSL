/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediasharingdsl

import groovy.xml.MarkupBuilder

/**
 *
 * @author vanyadeasy
 */
class MediaSharing {
    def databaseConn = new DatabaseConnector()
    
    def download(id) {
        def row = databaseConn.getMedia(id)
        println "Downloaded media from $row.url_path"
    }
    
    def sign(action) {
        [username: {un -> 
            [email: {email -> 
                [password: {pw ->
                    [first_name: {fn ->
                        [last_name: {ln ->
                            User user = new User(username: un,email: email,password: pw,first_name: fn,last_name: ln)
                            action(user)
                        }]
                    }]
                }]
            }]
        }]
    }
    
    def up = {
        databaseConn.insertUser(it)
    }
    
    def like(md) {
        [by: {un ->
            def user = databaseConn.getUser(un)
            databaseConn.insertAction(md, user.id, 'like')
        }]
    }
    
    def dislike(md) {
        [by: {un ->
            def user = databaseConn.getUser(un)
            databaseConn.insertAction(md, user.id, 'dislike')
        }]
    }
    
    def upload(catid){
        [file: {filename ->
            [title: {name -> 
                [type: {mimeType ->
                    [description: {description ->
                        [permission: {permission ->
                            [path: {urlPath ->
                                [by: {username ->
                                    def user =databaseConn.getUser(username)
                                    Media media = new Media(userId: user.id, categoryId: catid, name: name, filename: filename, description: description, urlPath: urlPath, mimeType: mimeType, permission: permission)
                                    databaseConn.insertMedia(media)
                                }]
                            }]
                        }]        
                    }]
                }]
            }]
        }]
    }
}
