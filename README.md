#Purpose:
Main purpose of this framework is allow AI developers to build object oriented model of brain.
Additional purpose is create platform which will allow to implement neuron net with any known design  
and run it localy  or in distributed way on cluster, cuda cluster, aws lambdas.

#Concepts:
Main concepts which will allow to build object oriented model of brain:


Signals are different data objects which passed on input, emits on middle layers and gets as result.


Signal processor is some function which process the one type( or subtypes) of signals and emit signals to axon.  

Note: it has access to neuron and axon. 
Signals can be continuous (moved to next run fixed amount of times, with changes or without)



Neuron is abstraction which store signals processor/processors for signal type/different signal types,  
 oder of signal type processing and axon. Note: neuron can be stateful or stateless.
 
 
Axon store connection to other neurons with weights for each type of signal.


Layer store the list of neurons which situated and input.


Result layer stores the final layer of neurons with associated result signals.


Studying algorithm has access  to all input/middle input/result and store studying logic. Also studying can be implemented with the help of signals immiting to below layers and cyclic processing before next input.

Note: Result signal from one/many neuron nets can be used as input to other. Such approach will allow to "debug" AI and combine neuron nets.   

#Phases:
1. Make core. It will implement just core concepts without distributed mode and neuron nets synchronization.
2. Add simple java distributed part with neuron nets synchronization.
3. Genrate maven artifacts, host javadocs
4. Add containers(docker/kubernetes) and infrastructure scripts python/shell.
5. Design and implement open stack cluster integration.
6. Add neuron net graphic designer which will collect data about implemented classes and will pass to graphic plugin for eclipse and/or idea.
7. Add cuda distributed mode.
8. Add aws lambda distributed mode.
9. Design and implement amazon cluster integration.

p.s. Fill free to contatct me. I am looking for contributors for this project.
p.p.s. Great thanks to kafedra of Informatics in Kharkiv National University of Radio and Electronics, Eugen Putiatin, Helen Matat, Tatiana Sinelnikova.
