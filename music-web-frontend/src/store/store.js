import { createStore, applyMiddleware } from "redux";
import modules from "./modules/song";
// import ReduxThunk from 'redux-thunk'
import promiseMiddleware from "redux-promise-middleware";

import { createLogger } from "redux-logger";

const logger = createLogger();
const pm = promiseMiddleware({
  promiseTypeSuffixes: ["PENDING", "SUCCESS", "FAILURE"]
});

const store = createStore(modules, applyMiddleware(logger, pm));

export default store;
