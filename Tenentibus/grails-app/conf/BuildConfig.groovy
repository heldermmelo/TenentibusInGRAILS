grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"



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
        
		excludes "grails-docs" // evita conflito do itext com #jasperreports
		// specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

	
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
         runtime 'mysql:mysql-connector-java:5.1.36'
        // runtime 'org.postgresql:postgresql:9.3-1101-jdbc41'
     //   test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
   
		 // inclui #jasperreports
		 
		 
/*		 compile('net.sf.jasperreports:jasperreports:5.6.1') {
			 excludes 'antlr', 'commons-logging',
					 'ant', 'mondrian', 'commons-javaflow','barbecue', 'xml-apis-ext','xml-apis', 'xalan', 'groovy-all', 'hibernate', 'saaj-api', 'servlet-api',
					 'xercesImpl','xmlParserAPIs','spring-core','bsh', 'spring-beans', 'jaxen', 'barcode4j','batik-svg-dom','batik-xml','batik-awt-util','batik-dom',
					 'batik-css','batik-gvt','batik-script', 'batik-svggen','batik-util','batik-bridge','persistence-api','jdtcore','bcmail-jdk16','bcprov-jdk16','bctsp-jdk16',
					 'bcmail-jdk14','bcprov-jdk14','bctsp-jdk14','xmlbeans', 'olap4j'
		 }
*/		 compile "com.lowagie:itext:2.1.7"
		 compile "org.apache.poi:poi:3.10-FINAL"
 
/*		 compile('ar.com.fdvs:DynamicJasper:5.0.2') { // #dynamicjasper gera #jasperreports dinâmicos. Não precisa criar o arquivo de report.
			 excludes 'jasperreports' // tenta baixar outra versão de #jasperreports
		 }
*/ 
		 build('org.grails:grails-docs:2.4.4') {
			 excludes 'itext' // resolve conflito de dependência do itext com o #jasperreports
		 }
 
		 
		 
		 
		 
    }

    plugins {
        // plugins for the build system only
		
		compile ":spring-security-core:2.0-RC4"
        build ":tomcat:7.0.55"

        // plugins for the compile step
        compile ":scaffolding:2.1.2"
        compile ':cache:1.1.8'
        compile ":asset-pipeline:2.1.4"

        // plugins needed at runtime but not for compilation
        runtime ":hibernate4:4.3.6.1" // or ":hibernate:3.6.10.18" or  ":hibernate4:4.3.6.1" original
        runtime ":database-migration:1.4.0"
        runtime ":jquery:1.11.1"

		 compile":br-validation:0.3" //valida CPF, CNPJ e CEP.
		
        // Uncomment these to enable additional asset-pipeline capabilities
        //compile ":sass-asset-pipeline:1.9.0"
        //compile ":less-asset-pipeline:1.10.0"
        //compile ":coffee-asset-pipeline:1.8.0"
        //compile ":handlebars-asset-pipeline:1.3.0.3"
    }
}
