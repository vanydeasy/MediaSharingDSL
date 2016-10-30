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
    
    def comment(md) {
        [by: {uname ->
            [parent: {parent -> 
                [content: {content -> 
                    def user = databaseConn.getUser(uname)
                    def par = databaseConn.getComment(parent)
                    databaseConn.insertComment(user.id, md, par.id, content)
                }]
            }]
        }]
    }
}
