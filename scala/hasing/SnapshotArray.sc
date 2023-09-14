class SnapshotArray(_length: Int) {

  import scala.collection.mutable.{Map, ArraySeq}

  private var lastSnap = 0
  private val snaps = Map.empty[(Int, Int), Int]

  def set(index: Int, `val`: Int): Unit = snaps.addOne((lastSnap, index), `val`)

  def snap(): Int = {
    val id = lastSnap
    lastSnap += 1
    id
  }

  def get(index: Int, snap_id: Int): Int = {
    var snap_idLooped = snap_id
    while (snap_idLooped >= 0) {
      snaps.get(snap_idLooped, index) match {
        case Some(value) => return value
        case None => snap_idLooped -= 1
      }
    }
    0
  }
}
