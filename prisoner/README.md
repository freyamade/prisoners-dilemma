# Prisoner
The following is a list of all the strategies defined in [this list](http://www.prisoners-dilemma.com/strategies.html), in the form of a task list.
The Prisoner strategies already implemented will be marked off.

## No Title
The follow strategies have no title in the referenced list;

- [x] Always Cooperate
    - Cooperates on every move
    - `Always(true)`
- [x] Always Defect
    - Defects on every move
    - `Always(false)`
- [x] Random Player
    - Makes a random move
- [x] Tit For Tat
    - Cooperates on the first move, then copies opponent's last move
    - `TitForTat(NICE)`
- [x] Grim Trigger
    - Cooperates until opponent defects, after which it always defects
- [x] Pavlov
    - Cooperates on the first move. If a reward or temptation payoff is received in the last round, then repeats last choice, otherwise uses opposite choice.
    - Temptation is (true, false), reward is (true, true).
- [x] Tit for Two Tats
    - Cooperates on the first move, and only defects after the opponent defects two times.
- [ ] Two Tits for Tat
    - Same as Tit For Tat except it defects twice whenever the opponent defects.
- [x] Gradual
    - Cooperates on the first move, and continues to do so until the opponent defects.
    - After the nth defect, responds with n consecutive defections and then 2 cooperates.
- [x] Soft Majority
    - Uses the move that the opponent has used most in the match, choosing to cooperate on a tie.
    - `Majority(SOFT)`
- [x] Hard Majority
    - Uses the move that the opponent has used most in the match, choosing to defect on a tie.
    - `Majority(HARD)`
- [ ] Naive Prober
    - Like Tit for Tat, but has a low probability of defecting.
- [ ] Remorseful Prober
    - Like Naive Prober, but it tries to break the series of mutual defections after defecting.
    - I'm going to assume that this means, after defecting, until the opponent cooperates, this strategy will continuously cooperate?
- [ ] Soft Grudger
    - Like Grim Trigger, except the opponent is punished with D D D D C C.
    - I'm not fully sure if this will then go back to cooperation, or will repeatedly use that pattern like a Periodic
- [ ] Prober
    - Starts with D C C, then defects if the opponent cooperates in the second and third move, otherwise acts like Tit for Tat
- [ ] Firm but Fair
    - Cooperates every move except after receiving a sucker payoff (true, false)

## Variants of Tit For Tat
- [ ] Generous Tit for Tat
    - Same as Tit for Tat, except has a probability to cooperate when the opponent defects
- [x] Suspicious Tit for Tat
    - Same as Tit for Tat except it defects on the first move
    - `TitForTat(NASTY)`
- [ ] Hard Tit for Tat
    - Cooperates on the first move, and continues to do so unless the opponent has defected for any of the three previous moves
- [ ] Contrite Tit for Tat
    - Same as Tit for Tat when there's no noise. In a noise environment, once it receives T by error, then it cooperates twice to recover mutual cooperation.
    - What I imagine this means is that when it gets T, cooperate twice?
- [x] Reverse Tit for tat
    - Defects on first move, then plays the opposite of the opponent's previous move.

## Adaptive Strategies
- [x] Adaptive Tit for Tat
    - An adaption rate r is used to compute a continuous variable ‘world’ according to the history moves of the opponent.
- [ ] Adaptive
    - Starts with C C C C C C D D D D D and then takes choices which have given the best average score re-calculated after every move.

## Heuristic / Rule based Strategies
- [ ] APavlov
    - Plays TFT in the first six moves and identifies the opponent by means of a rule-based mechanism.
    - The strategies of the opponent are categorized into four groups: cooperative, AllD, STFT, and Random.
    - If the opponent does not start defecting, it is identified to be cooperative and then APavlov will behave as TFT.
    - If the opponent defects more than four times in six consecutive moves, it is identified as an AllD type and then APavlov will always defect.
    - If the opponent just defects three times in six moves, it is identified as STFT type and then APavlov will adopt TFTT in order to recover mutual cooperation.
    - Any strategy that does not belong to the former three categories will be identified as a random type. In this situation, APavlov will always defect.
    - In order to deal with the situations in which the opponents may change their actions, the average payoff is computed every six rounds.
    - If it is lower than a threshold, the process of opponent identification may restart.
- [ ] Omega Tit for Tat
    - Starts with C, then plays Tit for Tat
    - It then keeps track of the randomness of the opponent and deadlock.
    - Based on mutual cooperation as the most mutually beneficial case, each change of move of the opponent makes the randomness value increase.
    - If randomness exceeds a threshold, start playing All Defect. If deadlock is detected, play an extra C to try and recover.

## Group Strategies
- [ ] Handshake
    - Defects on the first move, cooperates on the second.
    - If the other Prisoner does the same, always cooperate, otherwise always defect
- [ ] Fortress3.
    - Like Handshake, tried to recognize kin remembers by playing D D C.
    - If the opponent plays the same, cooperate until they defect.
    - Otherwise, it defects until the opponent defects twice in a row, then it will cooperate.
- [ ] Fortress4.
    - Like Handshake, tried to recognize kin remembers by playing D D D C.
    - If the opponent plays the same, cooperate until they defect.
    - Otherwise, it defects until the opponent defects three times in a row, then it will cooperate.
- [ ] Collective Strategy
    - Plays C then D in the first two moves.
    - If the opponent plays the same, play Tit for Tat.
    - Otherwise play All Defect
- [ ] Southampton Group Strategies
    - A group of strategies are designed to recognize each other through a predetermined sequence of 5-10 moves at the start.
    - Once two SGSs recognize each other, they will act as a 'master' or 'slave' role.
    - A master will always defect while a slave will always cooperate in order for the master to win the maximum points.
    - If the opponent is recognized as not being a SGS, it will immediately defect to minimize the score of the opponent.

## Zero-Determinant Strategies
- [ ] Extort-2
    - Enforces a linear relationship, SX − P = 2(SY − P), between the two IPD strategies’ scores.
    - Here SX and SY are the payoff of Extort-2 and its opponent respectively.
    - Extort-2 guarantees itself twice the share of payoffs above P, compared with those received by the opponent.
- [ ] ZDGTFT-2
    - Forces the relationship SX − R = 2(SY − R) between the two strategies’ scores.
