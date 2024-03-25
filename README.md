# Stream Gatherers: Example Usage

This repository is designed to showcase the usage of Stream Gatherers, a compelling new preview feature introduced in
Java with [JEP 461](https://openjdk.org/jeps/461). Stream Gatherers enhance the Stream API by introducing a more
flexible and powerful way to perform complex stream operations.

## Overview

Project is split into three parts:

- `examples.garherers.custom` - contains implementation of custom gatherers for solving common problems.
- `examples.garherers.builtin` - contains examples with usage of built-in gatherers.
- `examples.garherers.composition` - contains examples with combinations of more than one built in gatherer for solving
  more complex problems.

## Package `examples.garherers.custom`

The repository includes examples of the following gatherers, each tailored to address specific data processing needs:

- `DistinctByGatherer:` Demonstrates filtering unique elements from a stream based on specific attributes.
- `ReduceByGatherer:` Showcases how to reduce a stream of elements to a single, summarized value based on a specific
  criterion.
- `MaxByGatherer:` Highlights finding the maximum element in a stream according to a specified comparator.
- `MapNotNullGatherer:` Illustrates filtering null elements from a stream and applying a transformation to the remaining
  elements.
- `FindFirstGatherer:` Provides an example of retrieving the first element from a stream that matches a given predicate,
  emphasizing the gatherer's ability to streamline conditional searches within streams.

To demonstrate how they work we use each of them for operation on stream of `Money` objects.

## Package `examples.garherers.builtin`

In this part we overview built-in gatherers such as:

- `Gatherers.fold`
- `Gatherers.mapConcurrent`
- `Gatherers.scan`
- `Gatherers.windowFixed`
- `Gatherers.windowSliding`

We use each of them for operation on stream of integers.

## Package `examples.garherers.composition`

In this part we demonstrate how we can combine multiple gatherers for solving problems such as:

- **Safe animal distribution:** In addressing the challenge of safe animal distribution, we consider a sequence
  containing three types of animals: `WOLVE`, `SHEEP`, `SHEEP_DOG` The crucial requirement is to avoid any consecutive
  triple of animals where a wolf and a sheep are present without the protective presence of a sheepdog, as this poses a
  risk to the sheep.
- **Game simulation:** We aim to create pairs of players and simulate games between them. A game can end in a win for
  either player or a draw.
- **Bank account balance history:** Considering Money as a representation of both bank account balance and transactions,
  our aim is to trace the balance history across a series of transactions.

## Getting Started

To explore these examples, ensure you have a Java environment that supports preview features, as Stream Gatherers are
part of a preview feature in Java 22. Follow the setup instructions in this repository to enable the `--enable-preview`
flag in your Java compiler and runtime.