# Stream Gatherers: Example Usage

This repository is designed to showcase the usage of Stream Gatherers, a compelling new preview feature introduced in Java with [JEP 461](https://openjdk.org/jeps/461). Stream Gatherers enhance the Stream API by introducing a more flexible and powerful way to perform complex stream operations.

## Overview

Within the `money` package, we've developed a series of operations that demonstrate handling streams of complex objects. For our examples, we use the `Money` class to illustrate various scenarios. These operations highlight the versatility and potential of Stream Gatherers in processing data streams.

## Featured Operations

The repository includes examples of the following gatherers, each tailored to address specific data processing needs:

- **DistinctByGatherer**: Demonstrates filtering unique elements from a stream based on specific attributes.
- **ReduceByGatherer**: Showcases how to reduce a stream of elements to a single, summarized value based on a specific criterion.
- **MaxByGatherer**: Highlights finding the maximum element in a stream according to a specified comparator.
- **MapNotNullGatherer**: Illustrates filtering null elements from a stream and applying a transformation to the remaining elements.
- **FindFirstGatherer**: Provides an example of retrieving the first element from a stream that matches a given predicate, emphasizing the gatherer's ability to streamline conditional searches within streams.

## Getting Started

To explore these examples, ensure you have a Java environment that supports preview features, as Stream Gatherers are part of a preview feature in Java 22. Follow the setup instructions in this repository to enable the `--enable-preview` flag in your Java compiler and runtime.