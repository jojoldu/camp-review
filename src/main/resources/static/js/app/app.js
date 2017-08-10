
import './app.scss';
import Woowahan from 'woowahan';
import MainLayout from './view/layout/main-layout';
import MainView from './view/component/main/main';

//전역에서 jquery($) 사용가능 하도록 지원
global.$ = global.jQuery = Woowahan.$;

const app = new Woowahan();

const components = {
    url: '/',
    container: '#main-layout',
    view: MainView,
    layout: 'MainLayout'
};

const siteOption = {
    empty: page => {
        alert(`${page}는 없는 페이지입니다.`);
    }
};

app.start(components, siteOption);

app.on('error', function (err) {
    console.log(err);
});