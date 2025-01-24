import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id ("com.github.johnrengelman.shadow")
}

group = "com.akretsev"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencyManagement {
    dependencies {
        imports {
            mavenBom(SpringBootPlugin.BOM_COORDINATES)
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("alibouSecurity")
        archiveVersion.set("0.1")
        archiveClassifier.set("")
        manifest {
            attributes(mapOf("Main-Class" to "com.akretsev.alibou_security.AlibouSecurityApplication"))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
