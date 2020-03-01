# An example to build App references some hidden APIs of framework.jar

If you need to reference some APIs from framework.jar in An Android App, you can midify the config of gradle to make it possible.



#### Follow below guide:
- Archive the file `framework.jar` in the project, e.g. `app/systemlibraries/framework.jar` 
- Add below lines in `app/build.gradle`

```Gradle
dependencies {
    provided fileTree(dir: 'systemlibraries', include: ['*.jar'])
    ...
}

task pushDownJdkDependency {
    def imlFile = file("app.iml")
    println 'Change app.iml order'
    try {
        def parsedXml = (new XmlParser()).parse(imlFile)
        def jdkNode = parsedXml.component[1].orderEntry.find { it.'@type' == 'jdk' }
        parsedXml.component[1].remove(jdkNode)
        new Node(parsedXml.component[1], 'orderEntry', ['type': 'jdk', 'jdkName': "Android API 25 Platform", 'jdkType': 'Android SDK'])
        def writer = new StringWriter()
        new XmlNodePrinter(new PrintWriter(writer)).print(parsedXml)
    } catch (FileNotFoundException e) {
        println e.getMessage()
    }
}


gradle.projectsEvaluated {
    preBuild.dependsOn(pushDownJdkDependency)
    tasks.withType(JavaCompile) {
        options.compilerArgs << '-Xbootclasspath/p:./systemlibraries/framework.jar'
    }
}
```
