# 🎲 Jakaroo — 2D Multiplayer Board Game

A fully playable digital adaptation of the classic **Jakaroo** (Jackaroo) board game, built with **Java** and **JavaFX**. Developed as a university project at the German International University (GIU), Cairo.

## About the Game

Jakaroo is a popular Middle Eastern board game that combines strategy and luck. Players race to move all four of their marbles from the start area to their home base, using playing cards instead of dice. The game supports blocking, capturing, and tactical card play — making every round unpredictable.

This project brings the full Jakaroo experience to the screen: 1 human player vs 3 CPU opponents, a 100-cell circular board with safe zones, and a card system featuring both standard and wild cards.

## Features

- **Complete Game Engine** — 100-cell circular board with 4 color bases, safe zones, entry cells, and home areas
- **Card System** — standard cards (Ace, Four, Five, Seven, Ten, Jack, Queen, King) each with unique movement rules, plus wild cards (Burner & Saver) for special actions
- **CPU Opponents** — 3 AI players with randomized strategy that evaluate actionable marbles and attempt valid card plays
- **Custom Exception Hierarchy** — 11 exception classes for robust game-rule enforcement (illegal moves, invalid swaps, split out of range, etc.)
- **JavaFX GUI** — interactive board with FXML layout, CSS styling, and scene transitions (name entry → game board)
- **OOP Architecture** — abstract classes, interfaces, enums, and inheritance across a clean 5-package structure

## Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java |
| GUI | JavaFX (FXML + CSS) |
| IDE | Eclipse |
| Paradigm | OOP, MVC-inspired |

## Project Structure

```
src/
├── application/             # Entry point & UI
│   ├── Main.java            # JavaFX Application — scene management & event handling
│   ├── last.fxml            # Game board FXML layout
│   └── application.css      # Stylesheet
│
├── engine/                  # Core game logic
│   ├── Game.java            # Game state, turn management, deck & player orchestration
│   ├── GameManager.java     # Interface — sendHome, fieldMarble, discardCard
│   └── board/
│       ├── Board.java       # 100-cell circular track + safe zones
│       ├── BoardManager.java# Interface — move, swap, destroy, getActionableMarbles
│       ├── Cell.java        # Individual board cell
│       ├── CellType.java    # Enum: NORMAL, SAFE, BASE, ENTRY
│       └── SafeZone.java    # 4-cell safe corridor per player
│
├── model/                   # Data models
│   ├── Colour.java          # Enum: RED, GREEN, BLUE, YELLOW
│   ├── card/
│   │   ├── Card.java        # Abstract base — name, description, act(), validate()
│   │   ├── Deck.java        # Deck construction, shuffling, dealing
│   │   ├── standard/        # Ace, Four, Five, Seven, Ten, Jack, Queen, King, Standard, Suit
│   │   └── wild/            # Wild (abstract), Burner (destroy opponent), Saver (send to safe)
│   └── player/
│       ├── Player.java      # Hand management, card/marble selection
│       ├── Marble.java      # Marble with colour
│       └── CPU.java         # AI — randomized card-marble evaluation
│
└── exception/               # Custom exception hierarchy
    ├── GameException.java
    ├── ActionException.java
    ├── CannotFieldException.java
    ├── CannotDiscardException.java
    ├── IllegalDestroyException.java
    ├── IllegalMovementException.java
    ├── IllegalSwapException.java
    ├── InvalidCardException.java
    ├── InvalidMarbleException.java
    ├── InvalidSelectionException.java
    └── SplitOutOfRangeException.java
```

**38 Java classes** across 5 packages.

## How to Run

1. **Prerequisites** — Java 11+ and JavaFX SDK installed
2. **Clone the repo**
   ```bash
   git clone https://github.com/IsmailSamir1/Jakaroo.git
   cd Jakaroo
   ```
3. **Open in Eclipse** (or IntelliJ) with JavaFX configured
4. **Run** `application.Main` as a Java Application

## Card Actions

| Card | Action |
|------|--------|
| **Ace** | Enter the board OR move 1 step |
| **King** | Enter the board |
| **Four** | Move 4 steps backward |
| **Five** | Move 5 steps forward |
| **Seven** | Split movement between two marbles |
| **Ten** | Move 10 steps forward |
| **Jack** | Swap positions with an opponent's marble |
| **Queen** | Move 12 steps forward |
| **Burner** 🔥 | Destroy an opponent's marble (send it home) |
| **Saver** 🛡️ | Send your own marble to the safe zone |

## What I Learned

- Designing complex game state with OOP — abstract classes, interfaces, polymorphism, and enums
- Building interactive GUIs with JavaFX (FXML, CSS, scene transitions, event handling)
- Implementing AI decision-making with randomized card-marble evaluation
- Structuring a 38-class Java project with clean package separation and a custom exception hierarchy
- Enforcing game rules programmatically through validation and exception handling

## Context

Built during **Semester 2** (Spring 2025) at the **German International University**, Cairo — as part of coursework covering Java, OOP, and Data Structures.

## License

This project was developed for educational purposes at GIU.
