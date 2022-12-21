package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private final static List<Enterprise> enterprises = List.of(
          new Enterprise("ent_1", "Google", "ceo_2"),
          new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private final static List<Ceo> ceos = List.of(
          new Ceo("ceo_1", "Mark"),
          new Ceo("ceo_2", "Sundar"),
          new Ceo("ceo_3", "Bill")
  );

  /* get the ceo in ceos with the ceo_id */
  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    Objects.requireNonNull(ceo_id);
    var ceo = ceos.find(e -> ceo_id.equals(e.id));
    if(ceo == null){
      return CompletableFuture.completedFuture(Option.none());
    }
    return CompletableFuture.completedFuture(ceo);
  }

  /* get the entreprise in entreprises with the ceo_id */
  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    Objects.requireNonNull(ceo_id);
    var ent = enterprises.find(e -> e.ceo_id.equals(ceo_id));
    if(ent == null){
      return CompletableFuture.completedFuture(Option.none());
    }
    return CompletableFuture.completedFuture(ent);
  }

  /* get the tuple entreprise, ceo with the ceo_id */
  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    Objects.requireNonNull(ceo_id);
    var ent = enterprises.find(e -> e.ceo_id.equals(ceo_id));
    var ceo = ceos.find(e -> e.id.equals(ceo_id));
    if(ent == null || ceo == null){
      var tuple = new Tuple2<Option<Ceo>,Option<Enterprise>>(Option.none(),Option.none());
      return CompletableFuture.completedFuture(tuple);
    }
    var tuple = new Tuple2<>(ceo,ent);
    return CompletableFuture.completedFuture(tuple);
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.print(getCeoById("ceo_1").get().get());
    System.out.print(getEnterpriseByCeoId("ceo_1").get().get());
    System.out.print(getCEOAndEnterprise("ceo_1").get());
  }

}
