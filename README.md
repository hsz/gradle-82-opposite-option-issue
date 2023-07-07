# gradle-82-opposite-option-issue

Reported as: https://github.com/gradle/gradle/issues/25658


To reproduce the issue, call:

```bash
./gradlew wrapper -PgradleVersion=8.1.1
./gradlew myTask --no-feature
```

It should print the `true` value, as expected:

```
> Task :myTask
noFeature = true
```

After switching to Gradle `8.2`, it prints the `false` value instead, which isn't expected:

```bash
./gradlew wrapper -PgradleVersion=8.2
./gradlew myTask --no-feature
```

Result:

```
> Task :myTask
noFeature = false
```
