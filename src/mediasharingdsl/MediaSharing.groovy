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
    private final List<Media> medias = []
    def User[] users
    
    def create(String object) {
        println "Description not found"
    }
    
    def create(String object, desc) {
        if(object == "Media") {
            Media media = new Media(desc);
        }
        else println "Ho"
    }
    
    def printMedia() {
        for(int i=0;i<medias.size();i++)
            println medias[i].name
    }
}
