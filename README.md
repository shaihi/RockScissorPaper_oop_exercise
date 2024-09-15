# Instructions
This is a game of ✊, ✋, ✌
To make it work, you need to implement the logic by adding some Java classes and use OOP principals
## Add the GameElement Base Class:
This class will have a method compareWith(GameElement other) that each subclass will override.
## Add Subclasses (Rock, Paper, Scissors) that inherit from the above:
Each subclass will inherit from GameElement and implement the compareWith method to define specific interactions.
The return value for compareWith is as follows:
- "It's a tie!" if the elements are the same
- "You Lose!" if the other element beats the one that is implemented
- "You Win!" if the element implemented beats the received item

## Hints
- Use `instanceOf` keyword to compare elements of instances
- Note that the result is case sensitive
  - Can you think on how to make it case insensitive?
