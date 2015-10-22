# DbFlowListView 

This is a sample application to showcase separation between presentation and model updates.

It contains a list for read only access to a model (`SampleTable`) and a bunch of buttons to update the model. The idea is that buttons update the model and the refresh of the view is triggered by a `OnModelStateChangedListener`. This way, we can update the model from e.g. a `Service` and display the updates in a `ListView`.

# Dependencies

The main dependency is [DBFlow](https://github.com/Raizlabs/DBFlow).

# TODO (maybe)

* Use `RecyclerView`
* Optimise the usage (`RecyclerView`) to differentiate between operations (insert, delete ...)
