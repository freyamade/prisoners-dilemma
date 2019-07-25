# prisoners-dilemma
probably my favourite assignment in the four years of my degree, rewritten in kotlin to help learn kotlin.

## Background
The Prisoner's Dilemma was an assignment I had to do in my Java module in 2nd year, and it was one of my favourite assignments in the entirety of my degree.

[Prisoner's Dilemma](https://en.wikipedia.org/wiki/Prisoner%27s_dilemma) is a standard example of game theory in Computer Science.


The premise was simple, implement a basic form of the Prisoner's Dilemma in Java, with the following play styles;
    - Rand              - A equal random chance to Cooperate or Defect.
    - Nice Tit-for-Tat  - Start by cooperating, then play the opponent's previous move.
    - Nasty Tit-for-Tat - Start by defecting, then play the opponent's previous move.
    - Soft Majority     - Play the move the opponent has used most, using Cooperate in a tie.
    - Hard Majority     - Play the move the opponent has used most, using Defect in a tie.

Every prisoner is paired with every other prisoner, excluding itself, and they then play a game of Iterated Prisoner's Dilemma for *n* rounds.
After every prisoner has played every other prisoner, a league table should be printed showing the strategy and the total number of points earned.

Some extensions were given too;
    - Extend the program to include new strategies
        - For this, I found [this list](http://www.prisoners-dilemma.com/strategies.html) and did as many as I could within the timeframe for the assignment.
    - Extend the program to use Axelrod's original formula, which allowed Prisoners to play themselves.
        - Requires a little thought as only one set of points should be earned.
    - Evolution Tournament

## Evolution Tournament
This was the last thing I remember trying, and I remember being unable to tell if I had succeeded or not.
My guess is my implementation was lacking, but this was around 3 years ago, so maybe I can do better now.

Here's a direct copy from the assignment brief;

### Brief
    In an evolution tournament, there is an initial population of prisoners. Maybe the initial population contains m prisoners per strategy, for some positive integer m. Call this generation 0.

    The prisoners in generation 0 play each other in round robin fashion.

    At the end of this tournament, a new population of prisoners, generation 1, is created. It contains the same number of prisoners as in generation 0. But, points means offspring! So the number of nice_tit_for_tats in generation 1 will depend on the tit_for_tats' scores in generation 0; and similarly for each of the other strategies.

    Repeat this for a large number of generations. What kind of population mix do you end up with? Do the nice guys come out on top? Does the population stabilise (i.e. no changes in the make-up of successive generations)?

I might look into trying this again, and hopefully doing better.

## Java Version
The `java` branch contains the previous Java version that I wrote back in 2016, while the master branch contains my Kotlin version written in 2019, after hopefully becoming better at structuring projects.
