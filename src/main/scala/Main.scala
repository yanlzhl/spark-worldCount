import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
/**
  * Created by yanlz on 7/12/2017.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val line = sc.textFile("/usr/local/spark/spark-2.2.0-bin-hadoop2.7/test.txt")
    line.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _).collect().foreach(println)
    sc.stop()
  }
}
