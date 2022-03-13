"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var cors_1 = __importDefault(require("cors"));
var express_1 = __importDefault(require("express"));
var openapi_backend_1 = __importDefault(require("openapi-backend"));
// Create api with your definition file or object. This points to the openapi yaml spec
var api = new openapi_backend_1.default({ definition: '../../1_Specification/mediatheque.yaml' });
// Register your framework specific request handlers here
api.register({
    notFound: function (c, req, res) { return res.status(404).json({ err: 'not found' }); },
    notImplemented: function (c, req, res) {
        var _a;
        var _b = c.api.mockResponseForOperation((_a = c.operation.operationId) !== null && _a !== void 0 ? _a : ''), status = _b.status, mock = _b.mock;
        return res.status(status).json(mock);
    },
});
// Initialize the backend
api.init();
// Initialize the express server that will serve the api backend
var port = 9000;
var app = (0, express_1.default)();
app.use(express_1.default.json());
// Allow cors on all origins - its okay to do this for our simulator
app.use((0, cors_1.default)());
app.use(function (req, res) { return api.handleRequest(req, req, res); });
app.listen(port, function () {
    return console.info("api listening at http://localhost:".concat(port));
});
