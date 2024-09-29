# Gilded Rose starting position in Kotlin

Here you can see my take on the Gilded Rose Refactoring Kata.

## What has been changed?

+ **Classification of different items:** instead of cramming the logic of all sorts of items into one method, the items are first classified by their name via an enum class ```ItemNames```. These classes each contain their respective logic for updating. As required, the ```Item``` class has been left unaltered.
+ **Simplified logic:** much of the logic could be simplified into as little as a few lines with the help of Kotlin's features for more readable code.
+ **Testing:** The main ```GildedRose``` class and each item class have tests that ought to validate their update logic as thoroughly as possible. The TextTest approval test from the original repo has also been configured and included for this implementation.

## Run the tests from Command-Line

```
./gradlew test
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew run --args 10
```

You should make sure the gradle commands shown above work when you execute them in a terminal before trying to use TextTest (see below).


## Run the TextTest approval test that comes with this project

Run ```./start_texttest.sh``` in this folder. This should succeed. I only removed the lines that included the Conjured Mana Cake since those are now invalid considering the requirements.