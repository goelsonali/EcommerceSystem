package learn.app.product.management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import learn.app.product.management.action.ActionStrategy;
import learn.app.product.management.action.Adding;
import learn.app.product.management.action.Removing;
import learn.app.product.management.action.Type;
import learn.app.product.management.model.ProductOnLine;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  Map<Type,ActionStrategy> actionStrategies;

    public ProductService(List<ActionStrategy> strategies) {
        this.actionStrategies = new HashMap<>();
      for(ActionStrategy action: strategies) {
        if(action instanceof Adding) {
          actionStrategies.put(Type.ADD_PRODUCT, action);
        } else if(action instanceof Removing) {
          actionStrategies.put(Type.REMOVE_PRODUCT, action);
        }
      }
    }

    public String performAction(ProductOnLine productOnLine, Type action) {
      ActionStrategy actionStrategy = actionStrategies.get(action);
      return actionStrategy.perform(productOnLine);

    }
}
