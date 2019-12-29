package net.layers;
/***
 * Created by Rakovskyi Dmytro .
 *
 * Represents neuron result layer and encapsulate result interpretation logic
 *
 *
 */
public interface IResultLayer<K> extends ILayer {
    /*
    * Transfer result layer to result
    *
    * */
    K interpretResult();

}
