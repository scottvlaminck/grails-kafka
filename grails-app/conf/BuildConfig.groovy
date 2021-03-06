grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

//grails.project.repos.fileRepo.url = "file:///Users/charliek/tmp"
//grails.project.repos.fileRepo.type = "maven"
//grails.project.repos.default = "fileRepo"
//grails.release.scm.enabled = false

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
//		mavenLocal()
		grailsCentral()
        mavenCentral()
        mavenRepo "http://dl.bintray.com/content/charliek/maven"
    }
    dependencies {
		compile('smartthings:konsumer:0.0.6') {
            excludes([ group: 'org.slf4j', name: 'slf4j-log4j12'])
        }
    }

    plugins {
		build(":release:3.1.1", ":rest-client-builder:2.1.1") {
			export = false
		}
    }
}
