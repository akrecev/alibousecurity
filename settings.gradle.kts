rootProject.name = "alibou_security"

pluginManagement {
    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings

    plugins {
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot
    }
}