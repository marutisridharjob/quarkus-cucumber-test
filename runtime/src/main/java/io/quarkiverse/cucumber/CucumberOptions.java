package io.quarkiverse.cucumber;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apiguardian.api.API;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.core.snippets.SnippetType;
import io.cucumber.plugin.Plugin;

/**
 * Configures Cucumbers options via class type annotation.
 * Derived from JUnit4 CucumberOptions.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@API(status = API.Status.STABLE)
public @interface CucumberOptions {
    /**
     * @return true if glue code execution should be skipped
     */
    boolean dryRun() default false;

    /**
     * Either a URI or path to a directory of features or a URI or path to a
     * single feature optionally followed by a colon and line numbers.
     * <p>
     * When no feature path is provided, Cucumber will use the package of the
     * annotated class. For example, if the annotated class is
     * {@code com.example.RunCucumber} then features are assumed to be located
     * in {@code classpath:com/example}.
     *
     * @return array of files or directories
     * @see io.cucumber.core.feature.FeatureWithLines
     */
    String[] features() default {};

    /**
     * Package to load glue code (step definitions, hooks and plugins) from.
     * E.g: {@code com.example.app}
     * <p>
     * When no glue is provided, Cucumber will use the package of the annotated
     * class. For example, if the annotated class is
     * {@code com.example.RunCucumber} then glue is assumed to be located in
     * {@code com.example}.
     *
     * @return array of package names
     * @see io.cucumber.core.feature.GluePath
     */
    String[] glue() default {};

    /**
     * Package to load additional glue code (step definitions, hooks and
     * plugins) from. E.g: {@code com.example.app}
     * <p>
     * These packages are used in addition to the default described in
     * {@code #glue}.
     *
     * @return array of package names
     */
    String[] extraGlue() default {};

    /**
     * Only run scenarios tagged with tags matching {@code TAG_EXPRESSION}.
     * <p>
     * For example {@code "@smoke and not @fast"}.
     *
     * @return a tag expression
     */
    String tags() default "";

    /**
     * Register plugins. Built-in plugin types: {@code junit}, {@code html},
     * {@code pretty}, {@code progress}, {@code json}, {@code usage},
     * {@code unused}, {@code rerun}, {@code testng}.
     * <p>
     * Can also be a fully qualified class name, allowing registration of 3rd
     * party plugins.
     * <p>
     * Plugins can be provided with an argument. For example
     * {@code json:target/cucumber-report.json}
     *
     * @return array of plugins
     * @see Plugin
     */
    String[] plugin() default {};

    /**
     * Publish report to <a href=https://reports.cucumber.io>https://reports.cucumber.io</a>.
     * <p>
     *
     * @return {@code true} if reports should be published on the web
     */
    boolean publish() default false;

    /**
     * @return {@code true} if terminal output should be without colours
     */
    boolean monochrome() default false;

    /**
     * Only run scenarios whose names match one of the provided regular
     * expressions.
     *
     * @return an array of regular expressions
     */
    String[] name() default {};

    /**
     * @return the format of the generated snippets
     */
    SnippetType snippets() default SnippetType.UNDERSCORE;

    /**
     * Specify a custom ObjectFactory.
     * <p>
     * In case a custom ObjectFactory is needed, the class can be specified
     * here. A custom ObjectFactory might be needed when more granular control
     * is needed over the dependency injection mechanism.
     *
     * @return an {@link io.cucumber.core.backend.ObjectFactory} implementation
     */
    Class<? extends ObjectFactory> objectFactory() default CucumberBaseTest.CdiObjectFactory.class;
}