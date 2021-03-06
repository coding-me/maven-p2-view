package io.coding.me.m2p2.core.internal.metric

import kamon.metric.EntityRecorderFactory
import kamon.metric.instrument.InstrumentFactory
import kamon.metric.GenericEntityRecorder
import kamon.metric.instrument.Time
import kamon.Kamon

class ArtifactCollectorMetrics(instrumentFactory: InstrumentFactory) extends GenericEntityRecorder(instrumentFactory) {

  val queueSize = minMaxCounter("queue-size")
}

object ArtifactCollectorMetrics extends EntityRecorderFactory[ArtifactCollectorMetrics] {

  def apply(name: String) = Kamon.metrics.entity(ArtifactCollectorMetrics, name)

  def category: String = "insert-artifacts"
  def createRecorder(instrumentFactory: InstrumentFactory): ArtifactCollectorMetrics = new ArtifactCollectorMetrics(instrumentFactory)
}