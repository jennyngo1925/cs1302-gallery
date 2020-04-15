#!/bin/bash -ex
mvn clean
mvn compile
mvn -e -Dprism.order=sw exec:java -Dexec.mainClass="cs1302.gallery.GalleryDriver"
checkstyle -c cs1302_checks.xml src/main/java/cs1302/gallery/GalleryApp.java
checkstyle -c cs1302_checks.xml src/main/java/cs1302/gallery/GalleryDriver.java
