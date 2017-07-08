
import Style from './app.scss';
import Woowahan from 'woowahan';
import MainLayout from './view/layout/main-layout';
import MainView from './view/component/main/main';

global.$ = global.jQuery = Woowahan.$;

const app = new Woowahan();

const components = {
    url: '/',
    container: '#main-content',
    view: MainView,
    layout: MainLayout,
    pages: [
    ]
};

app.use(Woowahan.Layout('#main-layout', MainLayout));

const siteOption = {
    empty: page => {
        alert(`${page}는 없는 페이지입니다.`);
    }
};

app.start(components, siteOption);

app.on('error', function (err) {
    console.log(err);
});